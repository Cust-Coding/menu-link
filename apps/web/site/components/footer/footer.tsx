import Subscricao from "./subscricao";
import Link from "next/link";

export default function Footer(){
    const year = new Date().getFullYear();
    return(
        <footer className="w-full py-10  flex flex-col gap-2 items-center justify-center px-4 md:px-8">
            <div className="w-[99%] md:w-[90%] py-4 bg-green-600 rounded-xl flex flex-col md:flex-row items-center justify-center gap-2">
                <div className="w-[95%] md:w-[45%] py-4 ">
                      <p className="text-3xl md:text-6xl font-bold ">Subscreva à nossa newsletter</p>
                      
                </div>
                <div className="w-[95%] md:w-[45%] py-4 ">
                    <Subscricao/>
                </div>
                
            </div>

            <div className="w-[95%] py-4  rounded-xl flex flex-col md:flex-row items-center justify-center gap-2">
                <div className="w-[95%] md:w-[45%] py-4 ">
                    <h1 className="text-2xl font-bold"><Link href="/">Menu Link</Link></h1>
                    <p className="w-[90%]">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Sed aperiam minus aliquid accusantium odio numquam nam voluptatibus labore, quibusdam amet distinctio quo? Voluptatum quia atque earum necessitatibus reiciendis iure itaque!</p>
                </div>
                <div className="w-[95%] md:w-[45%] py-4  flex items-stretch justify-around gap-4">
                    <div className="flex flex-col ">
                        <h6 className="font-semibold">About</h6>
                        <Link href={'/'}>Pricing</Link>
                        <Link href={'/'}>features</Link>
                        <Link href={'/'}>Impat Report</Link>
                        <Link href={'/'}>Outros Produtos</Link>
                    

                    </div>
                    <div className="flex flex-col">
                        <h6 className="font-semibold">Support</h6>
                         <Link href={'/'}>Account</Link>
                        <Link href={'/'}>FQA</Link>
                        <Link href={'/'}>Contact</Link>
                        <Link href={'/'}>About Us</Link>


                    </div>
                    <div className="flex flex-col">
                        <h6 className="font-semibold">Legal</h6>
                        <Link href={'/'}>Termos de uso</Link>
                        <Link href={'/'}>Politica de privacidade</Link>
                        <Link href={'/'}>Refoud Policy</Link>
                    
                    </div>
                </div>
            </div>

             <div className="w-[95%] py-4 rounded-xl flex flex-col md:flex-row items-center justify-around gap-2">
                <div className="w-[95%] md:w-[45%] py-4 flex flex-col gap-1 justify-center items-center">
                    <h6 className="font-semibold">Metodos de Pagamentos</h6>
                    <div className="flex justify-center gap-2">
                        <span>Bitcoin</span>
                        <span>M-pesa</span>
                        <span>E-mola</span>
                    </div>
                </div>
                <div className="w-[45%] md:w-[45%] py-4 flex flex-col gap-1 justify-center items-center">
                    <h6 className="font-semibold">Redes Sociais</h6>
                    <div className="flex justify-center gap-2">
                        <span>Whatsapp</span>
                        <span>Linkedin</span>
                        <span>Intagram</span>
                        <span>Gmail</span>
                        <span>X(Twiter)</span>
                    </div>
                </div>
            </div>

             <div className="w-[95%] py-4 flex md:flex-row items-center justify-center">
                <span className="text-center">Desenhado por <a href={'/'}>CCS</a> Copyrigth&copy; {year} Todos Direitos Reservados</span>
            </div>
        </footer>
    );
}