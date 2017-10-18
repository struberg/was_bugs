package at.struct.wasbug23;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdater extends XmlAdapter<String, LocalDate> {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd");

    public LocalDate unmarshal(String v) {
        return v == null ? null : LocalDate.fromCalendarFields(DatatypeConverter.parseDate(v));
    }

    public String marshal(LocalDate v) {
        return v == null ? null : DATE_FORMATTER.print(v);
    }
}
