package platform.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "codes")
public class Code {

    @Id
    @Type(type = "uuid-char")
    @JsonIgnore
    private UUID id = UUID.randomUUID();

    @NotBlank
    private String code;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = DATE_PATTERN)
    @CreationTimestamp
    private LocalDateTime date;

    @NotNull
    private long time;

    @NotNull
    private int views;

    @JsonIgnore
    private boolean timeRestricted;

    @JsonIgnore
    private boolean viewsRestricted;

    private final static String DATE_PATTERN = "yyyy/MM/dd HH:mm:ss";

    @JsonIgnore
    public String getDateFormatted() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        return dateTimeFormatter.format(date);
    }

    @JsonGetter("time")
    public long getTimeLeft() {
        return isTimeRestricted() ? time - ChronoUnit.SECONDS.between(date, LocalDateTime.now()) : time;
    }
}
