using System.Data.Entity;

namespace Question2.Models
{
    public class ApplicationDbContext : DbContext
    {
        public DbSet<User> Users { get; set; }
    }
}