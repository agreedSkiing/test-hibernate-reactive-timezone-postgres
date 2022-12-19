package org.acme.to.json;

import java.util.Objects;

public class Output {

  public String withoutTimezoneField;
  public String withTimezoneField;
  public String withTimezoneGmt2Field;

  public static class Builder {

    private String withoutTimezoneField;
    private String withTimezoneField;
    private String withTimezoneGmt2Field;

    public Builder() {}

    Builder(
      String withoutTimezoneField,
      String withTimezoneField,
      String withTimezoneGmt2Field
    ) {
      this.withoutTimezoneField = withoutTimezoneField;
      this.withTimezoneField = withTimezoneField;
      this.withTimezoneGmt2Field = withTimezoneGmt2Field;
    }

    public Builder withoutTimezoneField(String withoutTimezoneField) {
      this.withoutTimezoneField = withoutTimezoneField;
      return Builder.this;
    }

    public Builder withTimezoneField(String withTimezoneField) {
      this.withTimezoneField = withTimezoneField;
      return Builder.this;
    }

    public Builder withTimezoneGmt2Field(String withTimezoneGmt2Field) {
      this.withTimezoneGmt2Field = withTimezoneGmt2Field;
      return Builder.this;
    }

    public Output build() {
      Objects.requireNonNull(this.withoutTimezoneField);
      Objects.requireNonNull(this.withTimezoneField);
      Objects.requireNonNull(this.withTimezoneGmt2Field);

      return new Output(this);
    }
  }

  private Output(Builder builder) {
    this.withoutTimezoneField = builder.withoutTimezoneField;
    this.withTimezoneField = builder.withTimezoneField;
    this.withTimezoneGmt2Field = builder.withTimezoneGmt2Field;
  }
}
