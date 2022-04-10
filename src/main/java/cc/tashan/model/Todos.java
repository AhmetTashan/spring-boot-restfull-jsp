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
public class Todos extends BaseModel {

    @Lob
    @Column(name = "content")
    @ApiModelProperty(value = "İçerik alanı", required = true)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ApiModelProperty(value = "Kayıtlı kullanıcının numarası", required = true)
    private Users userId;

}
