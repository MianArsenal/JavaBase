package com.regression.vo;

public class BookingConfirmVo implements IShipmentDataVo {

    private String bookingNumber;
    private String date;

    @Override
    public String toString() {
        return "BookingConfirmVo{" +
                "bookingNumber='" + bookingNumber + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
