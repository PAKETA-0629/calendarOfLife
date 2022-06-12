package edu.calendaroflife.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "weeks")
public class WeeksEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "num_of_week")
    private Integer numOfWeek;
    @Column(name = "num_of_year")
    private Integer numOfYear;
    @Column(name = "title")
    private String title;

    @Column(name = "color")
    private Integer[] color;
    @Column(name = "text")
    private String text;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeeksEntity that = (WeeksEntity) o;
        return id == that.id && numOfWeek == that.numOfWeek && Objects.equals(numOfYear, that.numOfYear) && Objects.equals(title, that.title) && Objects.equals(color, that.color) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numOfWeek, numOfYear, title, color, text);
    }
}
