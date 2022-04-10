package cc.tashan.dto;

import cc.tashan.model.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TodoCreateDto extends BaseTodo {

    private Users userId;

    private LocalDateTime createdAt = LocalDateTime.now();


}
