package cc.tashan.model;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class BaseModel {

    @Column(name = "created_at")
    protected LocalDateTime createdAt;

    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    protected LocalDateTime deletedAt;
}
