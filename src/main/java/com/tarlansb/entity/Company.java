package com.tarlansb.entity;

import lombok.*;
import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "name")
@ToString(exclude = "users")
@Builder
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
//    @OrderBy(clause = "username DESC, lastname ASC")
//    @OrderBy("personalInfo.firstname")
    @OrderColumn(name = "id")
    @SortNatural
//    @SortComparator()
    private SortedSet<User> users = new TreeSet<>();

    @Builder.Default
    @ElementCollection
    @CollectionTable(name = "company_locale", joinColumns = @JoinColumn(name = "company_id"))
//    @AttributeOverride(name = "lang", column = @Column(name = "language"))
//    private List<LocaleInfo> locales = new ArrayList<>();
    @Column(name = "description")
    private List<String> locales = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
        user.setCompany(this);
    }
}
