package cc.tashan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TodoUpdateDto extends BaseTodo{

    private Long id;

    private LocalDateTime updatedAt = LocalDateTime.now();
}
