import { Menu, X } from "lucide-react";
import { useState } from "react";
import { useTranslation } from "react-i18next";
import type {TranslationKeys} from "../i18n/i18n"
import ThemeToggle from "../ThemeToggle/themetoggle";
import LangToggle from "../i18n/langToggle";
import {  UserRound } from 'lucide-react';

export function MobileMenu() {
  const [isOpen, setIsOpen] = useState(false);
  const { t } = useTranslation();

  const menuKeys: Array<keyof TranslationKeys> = [
    "features",
    "pricing",
    "about",
    "support",
    "contact",
  ];
  

  return (
    
    <div className="flex items-center justify-center h-auto w-auto gap-2">
        <button className="bg-amber-50/20 w-7 flex items-center justify-center h-7 hover:text-green-600 hover:p-2 hover:font-semibold transition-colors duration-600 rounded-full p-1 cursor-pointer">
            <UserRound size={16}/>
        </button>
        <button
        onClick={() => setIsOpen(prev => !prev)}
        aria-label="Toggle menu"
        className="relative p-2 w-10 h-10 flex items-center justify-center"
        >

            <Menu
                size={24}
                className={`
                absolute transition-all duration-300 ease-in-out
                ${isOpen ? "rotate-90 opacity-0 scale-0" : "rotate-0 opacity-100 scale-100"}
                `}
            />

            
            <X
                size={24}
                className={`
                absolute transition-all duration-300 ease-in-out
                ${isOpen ? "rotate-0 opacity-100 scale-100" : "-rotate-90 opacity-0 scale-0"}
                `}
            />
        </button>


        

        
        <nav
            className={`
            overflow-hidden absolute top-13 w-screen right-0 left-0 pt-5 gap-5 text-black bg-black flex flex-col items-start justify-center transition-all duration-300 ease-in-out  pb-23
            ${isOpen ? " opacity-100" : "max-h-0 opacity-0"}
            `}
        >
            {menuKeys.map((key) => (
            <a
            key={String(key)}
            href={`#${key}`}
            className="text-dynamic ms-10 text-xl text-white hover:text-green-600 font-semibold transition-colors duration-300"
            >
            {t(key)}
            </a>
        ))}

        <div className="buttons ms-10 flex items-center justify-center gap-3">
                <LangToggle/>
                <ThemeToggle/>
                
            </div>
        </nav>

     </div>
   
  );
}
