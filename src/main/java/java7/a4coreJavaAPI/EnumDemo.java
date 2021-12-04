package java7.a4coreJavaAPI;

public enum EnumDemo {
      SUNDAY  (1),  //calls constructor with value =1
      MONDAY(2),
      TUESDAY   (3),
      WEDNESDAY  (4),
      THURSDAY(5),
      FRIDAY   (6),
      SATURDAY   (7)
      ; // semicolon needed when fields / methods follow

      private final int dayCode;

      EnumDemo(int dayCode) {
          this.dayCode = dayCode;
      }

      public int getLevelCode() {
          return this.dayCode;
      }
  }