package models;

public record Moneda(
    String base_code,
    String target_code,
    Double conversion_result) {
}
