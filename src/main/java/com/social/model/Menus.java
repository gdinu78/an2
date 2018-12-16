package com.social.model;

import com.social.enums.FavEnum;
import com.social.enums.LifeCycle;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@NamedQuery(
        name="Menus.fetchByType", query="SELECT m FROM Menus m WHERE m.menu_type = :menupar ORDER BY m.position"
)
public class Menus {
    private Long id;
    private String menu_type;
    private String menu_name;
    private int position;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(String menu_type) {
        this.menu_type = menu_type;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
