package com.lwin.expense_tracker.entity.user;


import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailLogin extends User{

    private String password;
}
