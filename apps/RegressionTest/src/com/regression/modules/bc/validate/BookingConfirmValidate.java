package com.regression.modules.bc.validate;

import com.regression.modules.IValidate;
import com.regression.vo.BookingConfirmVo;
import com.regression.vo.IShipmentDataVo;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookingConfirmValidate implements IValidate {

    private JdbcTemplate supportJdbcTemplate;
    private JdbcTemplate partyJdbcTemplate;
    private JdbcTemplate adminJdbcTemplate;

    @Override
    public boolean validate(IShipmentDataVo dataVo) {
        BookingConfirmVo bookingConfirmVo = (BookingConfirmVo) dataVo;
        return validateSimpleBc(bookingConfirmVo);
    }

    private boolean validateSimpleBc(BookingConfirmVo bookingConfirmVo) {
        String sql = "Select count(*) From CS2_Bkg_Cfm C Where C.Bkg_Num = '" + bookingConfirmVo.getBookingNumber() + "'";
        int count = this.supportJdbcTemplate.queryForInt(sql);
        return count == 1;
    }

    public JdbcTemplate getSupportJdbcTemplate() {
        return supportJdbcTemplate;
    }

    public void setSupportJdbcTemplate(JdbcTemplate supportJdbcTemplate) {
        this.supportJdbcTemplate = supportJdbcTemplate;
    }

    public JdbcTemplate getPartyJdbcTemplate() {
        return partyJdbcTemplate;
    }

    public void setPartyJdbcTemplate(JdbcTemplate partyJdbcTemplate) {
        this.partyJdbcTemplate = partyJdbcTemplate;
    }

    public JdbcTemplate getAdminJdbcTemplate() {
        return adminJdbcTemplate;
    }

    public void setAdminJdbcTemplate(JdbcTemplate adminJdbcTemplate) {
        this.adminJdbcTemplate = adminJdbcTemplate;
    }
}
