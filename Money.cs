namespace Items
{
    public class Money
    {
        public string Currency { get; set; }
        public decimal Amount { get; set; }

        public Money(string currency, decimal amount)
        {
            Currency = currency;
            Amount = amount;
        }
    }
}