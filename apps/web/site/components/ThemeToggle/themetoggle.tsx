import { Sun, Moon } from "lucide-react";
import { useEffect, useState } from "react";

export default function ThemeToggle() {
  
  const [theme, setTheme] = useState(() => {
    if (typeof window !== "undefined") {
      return localStorage.getItem("theme") || "light";
    }
    return "light";
  });

  useEffect(() => {
    const root = window.document.documentElement;

    if (theme === "dark") {
      root.classList.add("dark");
    } else {
      root.classList.remove("dark");
    }

    localStorage.setItem("theme", theme);
  }, [theme]);
  return (
    <div className="flex gap-2 items-center bg-foreground/8 p-0.5 justify-center rounded-full">
    
      <div
        suppressHydrationWarning={true}
        
        className={`items-center justify-center flex rounded-full cursor-pointer ${
          theme === "light" ? "bg-green-50/30" : " "
        }`}
        onClick={() => setTheme("light")}
        tabIndex={0}
      >
        <Sun size={12} color={theme === "light" ? "orange" : "gray"}
        className={`transition-all ${
    theme === "light" 
      ? "text-orange-500 stroke-[3px]" 
      : "text-black"
  }`} />
      </div>

    
      <div
        className={`items-center p-1 justify-center flex rounded-full cursor-pointer ${
          theme === "dark" ? "bg-green-50/30" : ""
        }`}
        onClick={() => setTheme("dark")}
        tabIndex={0}
      >
        <Moon size={10} color={theme === "dark" ? "blue" : "gray"} />
      </div>
    </div>
  );
}

// //Melhor deixar no caso da minha cena dar stress import { Sun, Moon } from "lucide-react";
// import { useEffect, useState } from "react";

// export default function ThemeToggle() {
//   const [theme, setTheme] = useState(
//     localStorage.getItem("theme") || "light"
//   );

//   useEffect(() => {
//     if (theme === "dark") {
//       document.documentElement.style.setProperty("--background", "#0a0a0a");
//       document.documentElement.style.setProperty("--foreground", "#ededed");
//       document.documentElement.classList.remove("text-black");
//       document.documentElement.classList.add("text-white");
//     } else {
//       document.documentElement.style.setProperty("--background", "#ffffff");
//       document.documentElement.style.setProperty("--foreground", "#171717");
//           document.documentElement.classList.add("text-black");
//       document.documentElement.classList.remove("text-white");
//     }
//     localStorage.setItem("theme", theme);
//   }, [theme]);

//   return (
//     <div className="flex gap-2 items-center bg-amber-50/20 p-0.5 justify-center rounded-full">
//       <div
//         className={`items-center justify-center flex rounded-full cursor-pointer ${
//           theme === "light" ? " bg-green-50/30" : ""
//         }`}
//         onClick={() => setTheme("light")}
//         tabIndex={0}
//       >
//         <Sun size={10} color={theme === "light" ? "white" : "black"} />
//       </div>

//       <div
//         className={`items-center p-1 justify-center flex rounded-full cursor-pointer ${
//           theme === "dark" ? "bg-green-50/30" : ""
//         }`}
//         onClick={() => setTheme("dark")}
//         tabIndex={0}
//       >
//         <Moon size={10} color={theme === "dark" ? "white" : "black"} />
//       </div>
//     </div>
//   );
// }
