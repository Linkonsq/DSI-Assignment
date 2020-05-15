using Question2.Models;
using System.Linq;
using System.Web.Mvc;

namespace Question2.Controllers
{
    public class UserController : Controller
    {
        private readonly ApplicationDbContext _context;

        public UserController()
        {
            _context = new ApplicationDbContext();
        }

        protected override void Dispose(bool disposing)
        {
            _context.Dispose();
        }

        // GET: User
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Login()
        {
            return View();
        }

        private bool Validate(User user)
        {
            var validUser = _context.Users.SingleOrDefault(u => u.Email == user.Email && u.Password == user.Password);
            return validUser != null;
        }

        public ActionResult InvalidUser()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Login(User user)
        {
            var validUser = Validate(user);

            if (validUser)
            {
                return RedirectToAction("Index", "User");
            }
            else
            {
                return RedirectToAction("InvalidUser", "User");
            }
        }

        public ActionResult Register()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Register(User user)
        {
            _context.Users.Add(user);
            _context.SaveChanges();

            return RedirectToAction("Login", "User");
        }
    }
}