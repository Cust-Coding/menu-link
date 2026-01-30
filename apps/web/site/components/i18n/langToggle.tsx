import { Languages, ChevronDown } from "lucide-react";
import { DropdownHover } from "../ui/DropdownHover";
export default function LangToggle(){
    return(
        
        <DropdownHover
            button={
                <div className=" flex items-center gap-1 bg-foreground/8 p-1 justify-center rounded-sm cursor-pointer">
                    <Languages size={16}/> 
                    <ChevronDown size={13}/>
                </div>
            }
            
        >
           
            <div className="flex flex-col items-center justify-center">
                <button className="px-3 py-1 cursor-pointer hover:font-semibold">
                    PT
                </button>
                <span className="w-[80%] h-[1px] bg-black/40"></span>
                <button className="px-3 py-1 cursor-pointer hover:font-semibold">
                    EN
                </button>
            </div>

        </DropdownHover>
    );
}