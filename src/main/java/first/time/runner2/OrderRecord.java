package first.time.runner2;

//What is a record in Java?
//
//A record in Java is a special kind of class introduced in Java 14 as a preview feature and officially added in Java 16. The primary purpose of records is to model immutable data in a concise and structured way.
//
//A record in Java automatically provides implementations for several commonly used methods (like equals(), hashCode(), and toString()) based on its fields. In essence, records are a special kind of class designed to be transparent carriers for immutable data.

public record OrderRecord(
        String customerName,
        String  productName,
        int quantity
) {
}
