package com.bangbang.domain.alarm;

import com.bangbang.domain.AlarmDatetime;
import com.bangbang.domain.AlarmDatetime;
import com.bangbang.domain.sign.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "alarm")
public class Alarm extends AlarmDatetime {
  @Id
  @Column(name = "alarm_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long alarmId;

  @Column(name = "alarm_comment", length = 20, nullable = false)
  private String alarmComment;
  @Column(name = "alarm_status", nullable = false)
  private Integer alarmStatus;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Builder
  public Alarm(Long alarmId, String alarmComment, Integer alarmStatus, User user){
    this.alarmId = alarmId;
    this.alarmComment=alarmComment;
    this.alarmStatus = alarmStatus;
    this.user = user;
  }
}