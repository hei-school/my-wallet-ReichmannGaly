namespace Items
{
  public class IDCard
  {
    public string Name { get; set; }
    public string Number { get; set; }
    public bool Lost { get; set; }

    public IDCard(string name, string number, bool lost)
    {
        Name = name;
        Number = number;
        Lost = lost;
    }
  }
}
