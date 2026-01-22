import { Languages, ChevronDown } from "lucide-react";
export default function LangToggle(){
    return(
        <div className=" flex items-center gap-1 bg-amber-50/20 p-1 justify-center rounded-sm cursor-pointer">
            <Languages size={16}/> 
            <ChevronDown size={13}/>
        </div>
    );
}