package com.inditex.retail.shopprice.module.shared.utils;

import com.inditex.retail.shopprice.app.constants.AppConstants;
import com.inditex.retail.shopprice.module.shared.exceptions.DomainException;
import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DataBaseConverter {

    public String dateToString(final Date date) {
        if (null == date) {
            return null;
        }
        final DateFormat dateFormat = new SimpleDateFormat(AppConstants.DATE_PATTERN_YYYYMMDDHHMMSS);
        return dateFormat.format(date);
    }

    public Date stringToDate(final String date) {
        try {
            final DateFormat dateFormat = new SimpleDateFormat(AppConstants.DATE_PATTERN_YYYYMMDDHHMMSS);
            return dateFormat.parse(date);
        } catch (ParseException e) {
           log.error("Error to parte date: {}, {}", date, e);
           throw new DomainException("Error to parse date:" + date);
        }
    }
}
