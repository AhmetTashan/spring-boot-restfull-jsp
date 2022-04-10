package cc.tashan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteDto {

    private Long id;

    private LocalDateTime deletedAt = LocalDateTime.now();
}
