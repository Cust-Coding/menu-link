'use client'; 
import Nav from "./nav";

export default function Navbar(){

    

    }
    return(
        <div className="flex w-full p-2 bg-amber-100 items-center justify-around ">
           <div className="logo">
            <h2 className="text-black">Menu Link</h2>
           </div>
           <div className="menudesktop items-center justify-center gap-6 hidden md:flex">
            <Nav/>
           </div>
        </div>
    );
}