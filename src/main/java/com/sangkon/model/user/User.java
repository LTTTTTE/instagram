package com.sangkon.model.user;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "username"})
@Builder
@Table
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String email;
    private boolean isPrivate;
    private String url;
    private String bio;
    private String sex;
    private String phone;
    private String imagePath;
    private Instant createdAt;
    private Instant updatedAt;
}
