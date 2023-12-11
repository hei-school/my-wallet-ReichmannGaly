namespace Items
{
  public class BusinessCard
  {
    public string Owner { get; set; }
    public string CompanyName { get; set; }

    public BusinessCard(string owner, string companyName)
    {
        Owner = owner;
        CompanyName = companyName;
    }
  }
}

