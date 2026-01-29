import PricingCards from "./ui/PricingCards";

export default function Pricing(){
    return(
        <div className="flex items-center w-full my-30 min-h-[100vh] justify-center flex-col">
            <h2 className="text-2xl font-semibold text-center md:text-4xl">The Perfect Plan for Your Needs</h2>

            <h6 className="text-center w-[70%] md:w-[45%] ">Our transparent pricing makes iteasy to find a plan that works within your financial constraints </h6>
            <PricingCards/>
        </div>
    );
}