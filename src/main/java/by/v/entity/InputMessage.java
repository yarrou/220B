package by.v.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class InputMessage {
    private String text;
    private String email;
    private String name;
}
