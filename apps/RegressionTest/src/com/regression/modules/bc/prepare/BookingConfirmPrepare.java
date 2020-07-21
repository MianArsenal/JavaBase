package com.regression.modules.bc.prepare;

import com.regression.modules.IPrepare;
import com.regression.util.EmsTemplate;
import com.regression.util.FileUtil;
import com.regression.vo.BookingConfirmVo;

import java.util.Calendar;

public class BookingConfirmPrepare implements IPrepare<BookingConfirmVo> {

    EmsTemplate emsTemplate;

    @Override
    public BookingConfirmVo prepare() {
        BookingConfirmVo bookingConfirmVo = buildBookingConfirmVo();
        this.prepareSimpleBc(bookingConfirmVo);
        return bookingConfirmVo;
    }

    private BookingConfirmVo buildBookingConfirmVo() {
        BookingConfirmVo bookingConfirmVo = new BookingConfirmVo();
        String currentTimeMillis = String.valueOf(System.currentTimeMillis());
        bookingConfirmVo.setBookingNumber(currentTimeMillis);
        bookingConfirmVo.setDate(Calendar.getInstance().getTime().toString().substring(4, 10));
        return bookingConfirmVo;
    }

    private void prepareSimpleBc(BookingConfirmVo bookingConfirmVo) {
        this.emsTemplate.sendToQueue("Cargosmart.COSCON.CD.BC.INPUT.PKL",
                FileUtil.readFileContent("resource/data/bc/simple_bc.xml")
                        .replaceAll("CurrentTimeMillis", bookingConfirmVo.getBookingNumber())
                        .replaceAll("MMM dd", bookingConfirmVo.getDate()));
    }

    public EmsTemplate getEmsTemplate() {
        return emsTemplate;
    }

    public void setEmsTemplate(EmsTemplate emsTemplate) {
        this.emsTemplate = emsTemplate;
    }
}
