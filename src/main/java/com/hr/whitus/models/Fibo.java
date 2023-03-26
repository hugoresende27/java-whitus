package com.hr.whitus.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = Fibo.TABLE_NAME)
public class Fibo {

    public interface CreateFibo{
        //create this empty interfaces to guarantee
        //that is respected NotNull, NotEmpty and Size
        //TO STUDY
    }


    public static final String TABLE_NAME = "fibo";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id 1,2,3,4 autoincrement
    @Column(name = "id", unique = true)
    private Long id;//use Integer to not get null error, Long to not get bigger number

    @Column(name = "start",  nullable = false)
    @NotNull(groups = CreateFibo.class)
    @NotEmpty(groups = CreateFibo.class)
    private Long start;

    @Column(name = "end",  nullable = false)
    @NotNull(groups = CreateFibo.class)
    @NotEmpty(groups = CreateFibo.class)
    private Long end;

    @Column(name = "sequence",  length = 1000000 ,nullable = false)
    @NotNull(groups = CreateFibo.class)
    @NotEmpty(groups = CreateFibo.class)
    private String sequence;

    public Fibo() {
    }

    public Fibo(Long id, Long start, Long end, String sequence) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.sequence = sequence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean equals(Object obj) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Fibo fibo = (Fibo) o;
//        return Objects.equals(id, fibo.id) && Objects.equals(start, fibo.start) && Objects.equals(end, fibo.end) && Objects.equals(sequence, fibo.sequence);

        if (obj == this){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Fibo)){
            return false;
        }
        Fibo other = (Fibo) obj;
        if (this.id == null){
            if (other.id != null){
                return false;
            } else if (!this.id.equals(other.id)){
                return false;
            }
        }
        return Objects.equals(id, other.id) && Objects.equals(start, other.start) && Objects.equals(end, other.end) && Objects.equals(sequence, other.sequence);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * prime + ((this.id == null) ? 0 : this.id.hashCode());
        return result;

    }
}
