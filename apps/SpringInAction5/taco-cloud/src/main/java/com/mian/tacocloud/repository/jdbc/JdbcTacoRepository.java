package com.mian.tacocloud.repository.jdbc;

import com.mian.tacocloud.domain.Ingredient;
import com.mian.tacocloud.domain.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;

@Repository
public class JdbcTacoRepository implements TacoRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTacoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Taco save(Taco taco) {
        long tacoId = saveTacoInfo(taco);
        taco.setId(tacoId);
        for (Ingredient ingredient : taco.getIngredients()) {
            saveIngredientToTaco(ingredient.getId(), tacoId);
        }
        return taco;
    }

    private long saveTacoInfo(Taco taco) {
        taco.setCreatedAt(new Date());
        PreparedStatementCreator creator = connection -> {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into Taco (name, createdAt) values (?, ?)",
                    new String[]{"id"}
            );
            statement.setString(1, taco.getName());
            statement.setTimestamp(2, new Timestamp(taco.getCreatedAt().getTime()));
            return statement;
        };
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(creator, keyHolder);
        return keyHolder.getKey().longValue();
    }

    private void saveIngredientToTaco(String ingredientId, long tacoId) {
        this.jdbcTemplate.update("insert into Taco_Ingredients (taco, ingredient) values (?, ?)",
                tacoId,
                ingredientId);
    }
}
