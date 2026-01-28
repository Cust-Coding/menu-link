import { ReactNode } from "react";

type DropdownHoverProps = {
    button : ReactNode;
    children: ReactNode;
}

export  function DropdownHover({button, children}: DropdownHoverProps){
    return(
        <div className="relative inline-block group">

            <div className="cursor-pointer">
                {button}
            </div>

            <div className=" absolute left-0 mt-2 z-50 opacity-0 invisible group-hover:opacity-100 group-hover:visible transition-all duration-300">
                <div className="bg-white/90 text-black rounded-md ">
                    {children}
                </div>
            </div>
        </div>
    );
}


