package platform.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Code {

    @NotBlank
    private String code;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = DATE_PATTERN)
    private LocalDateTime date;

    private final static String DATE_PATTERN = "yyyy/MM/dd HH:mm:ss";

    @JsonIgnore
    public String getDateFormatted() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        return dateTimeFormatter.format(date);
    }
}
