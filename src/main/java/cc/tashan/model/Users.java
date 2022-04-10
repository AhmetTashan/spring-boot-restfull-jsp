package cc.tashan.model;

import cc.tashan.enums.UserRole;
import cc.tashan.enums.UserStatus;
//import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@ApiModel(value = "Users", description = "Users entity")
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", length = 64, nullable = false)
    private String username;

    @Column(name = "password", length = 128, nullable = false)
    private String password;

    @Column(name = "email", length = 128)
    private String email;

    @Column(
            name = "role",
            columnDefinition = "enum('ADMIN', 'USER') default 'USER'"
    )
    @Enumerated(EnumType.STRING)
    @ColumnDefault("'USER'")
    private UserRole role;

    @Column(
            name = "status",
            columnDefinition = "ENUM('ACTIVE', 'INACTIVE', 'BANNED') default 'INACTIVE'"
    )
    @Enumerated(EnumType.STRING)
    @ColumnDefault("'INACTIVE'")
    private UserStatus status;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private List<Todos> todos;

    @Column(name = "created_at")
    protected LocalDateTime createdAt;

    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    protected LocalDateTime deletedAt;
}
