namespace Items
{
  public class CreditCard
  {
    public string Owner { get; set; }
    public string Number { get; set; }
    public string ExpirationDate { get; set; }

    public CreditCard(string owner, string number, string expirationDate)
    {
        Owner = owner;
        Number = number;
        ExpirationDate = expirationDate;
    }
  }
}

