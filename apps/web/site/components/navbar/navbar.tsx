'use client'; 
import Nav from "./nav";
import { Sun, Moon, UserRound } from 'lucide-react';
import { useState } from 'react';
import ThemeToggle from "../ThemeToggle/themetoggle";
import LangToggle from "../i18n/langToggle";

export default function Navbar(){

    return(
        <div className="flex z-10 w-full fixed top-0 p-3 bg-transparent  items-center justify-around ">
           <div className="logo">
            <h2 className="">Menu Link</h2>
           </div>
           <div className="menudesktop items-center justify-center gap-6 hidden md:flex">
            <Nav/>
           </div>
           <div className="buttons flex items-center justify-center gap-3">
            <LangToggle/>
            <ThemeToggle/>
            <button className="bg-amber-50/20 hover:text-green-600 hover:p-2 hover:font-semibold transition-colors duration-600 rounded-full p-1 cursor-pointer">
                <UserRound size={16}/>
            </button>
            
           </div>
        </div>
    );
}