package main.com.w1zer.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class Toad {
    private long id;
    private String name;
    private String type;
    private long weight;
    private BigDecimal length;
    private Date birthday;
    private String description;
    private long idProfile;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(long idProfile) {
        this.idProfile = idProfile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toad toad = (Toad) o;
        return id == toad.id && weight == toad.weight && idProfile == toad.idProfile && name.equals(toad.name) &&
                Objects.equals(type, toad.type) && Objects.equals(length, toad.length) &&
                Objects.equals(birthday, toad.birthday) && Objects.equals(description, toad.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, weight, length, birthday, description, idProfile);
    }
}
