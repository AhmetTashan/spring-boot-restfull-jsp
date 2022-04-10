package cc.tashan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@ApiModel(value = "Todos", description = "Todos entity")
@Table(name = "todos")
public class Todos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Todos id", example = "1")
    private Long id;

    @Lob
    @Column(name = "content")
    @ApiModelProperty(value = "İçerik alanı", required = true)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ApiModelProperty(value = "Kayıtlı kullanıcının numarası", required = true)
    private Users userId;

    @Column(name = "created_at")
    @ApiModelProperty(value = "Oluşturulma tarihi", required = true)
    protected LocalDateTime createdAt;

    @Column(name = "updated_at")
    @ApiModelProperty(value = "Güncellenme tarihi", required = true)
    protected LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    @ApiModelProperty(value = "Silinme tarihi", required = true)
    protected LocalDateTime deletedAt;
}
