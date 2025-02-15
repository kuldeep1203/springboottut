package first.time.runner2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
        @JsonProperty("c-name") //will map cname from request to customerName
        private String customerName;
        @JsonProperty("p-name")
        private String productName;
        @JsonProperty("quantity")
        private int quantity;

        @Override
        public String toString() {
                return "Order{" +
                        "customerName='" + customerName + '\'' +
                        ", productName='" + productName + '\'' +
                        ", quantity=" + quantity +
                        '}';
        }

        public int getQuantity() {
                return quantity;
        }

        public void setQuantity(int quantity) {
                this.quantity = quantity;
        }

        public String getProductName() {
                return productName;
        }

        public void setProductName(String productName) {
                this.productName = productName;
        }

        public String getCustomerName() {
                return customerName;
        }

        public void setCustomerName(String customerName) {
                this.customerName = customerName;
        }
}
