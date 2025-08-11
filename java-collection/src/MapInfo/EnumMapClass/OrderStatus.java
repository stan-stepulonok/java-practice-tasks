package MapInfo.EnumMapClass;

public enum OrderStatus {

    PENDING("Order received, waiting for processing") {
        @Override
        public String getDescription() {
            return this.ordinal() + ". " + super.getDescription();
        }
    },
    PROCESSING("Order is being prepared")  {
        @Override
        public String getDescription() {
            return this.ordinal() + ". " + super.getDescription();
        }
    },
    SHIPPED("Order shipped to customer")  {
        @Override
        public String getDescription() {
            return this.ordinal() + ". " + super.getDescription();
        }
    },
    DELIVERED("Order delivered to customer")   {
        @Override
        public String getDescription() {
            return this.ordinal() + ". " + super.getDescription();
        }
    },
    CANCELLED("Order cancelled") {
        @Override
        public String getDescription() {
            return this.ordinal() + ". " + super.getDescription();
        }
    };

    private String description = "No description provided.";

    OrderStatus(String description){
        this.description = description;
    };

    public String getDescription() {
        return "The order status: " + this.name().toLowerCase() + " -> " + description;
    }


    public String toString() {
        return getDescription();
    }

}
