'use client'; 
import Nav from "./nav";
import {  UserRound } from 'lucide-react';
import ThemeToggle from "../ThemeToggle/themetoggle";
import LangToggle from "../i18n/langToggle";
import { MobileMenu } from "./MobileMenu";

export default function Navbar(){

    return(
        <div className="flex z-10 w-full fixed top-0 p-3 bg-transparent  items-center justify-around ">
           <div className="logo">
            <h2 className="">Menu Link</h2>
           </div>
           <div className="menudesktop items-center justify-center gap-6 hidden md:flex">
            <Nav/>
           </div>
           <div className="mobilemenu flex md:hidden">
            <MobileMenu/>
           </div>
           <div className="buttons hidden md:flex items-center justify-center gap-3">
            <LangToggle/>
            <ThemeToggle/>
            <button className="bg-foreground/20 hover:text-green-600 hover:p-2 hover:font-semibold transition-colors duration-600 rounded-full p-1 cursor-pointer">
                <UserRound size={16}/>
            </button>
            
           </div>
        </div>
    );
}