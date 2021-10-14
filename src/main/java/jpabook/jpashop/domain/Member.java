package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name ="member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @JsonIgnore //양방향 관계에서 하나는 이걸설정
    @OneToMany(mappedBy = "member") //맵핑되는 대상
    private List<Order> orders = new ArrayList<>();
}
