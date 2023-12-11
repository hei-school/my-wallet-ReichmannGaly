namespace Items 
{
  public class DrivingLicence
  {
    public string Owner { get; set; }
    public string Category { get; set; }
    
    public DrivingLicence(string owner, string category)
    {
        Owner = owner;
        Category = category;
    }
  }
}