export default function Pricing(){
    return(
        <div className="flex items-center w-full min-h-[100vh] justify-center flex-col">
            <h2 className="text-2xl font-semibold text-center md:text-4xl">The Perfect Plan for Your Needs</h2>

            <h6 className="text-center w-[70%] md:w-[45%] ">Our transparent pricing makes iteasy to find a plan that works within your financial constraints </h6>
            <div className=" my-2 flex items-center justify-center flex-wrap gap-4">
                <div className="rounded-2xl p-3 bg-gray-700/15 my-1.5">
                    <h2 className="font-bold text-orange-500 ">Free</h2>
                    <p className="font-bold my-1.5"><span className="text-xl ">MZN O</span>/Mes</p>
                    <p className="font-semibold">Iclude:</p>
                </div>
                <div className="rounded-2xl p-3 bg-gray-700/15">
                    <h2 className="font-bold text-orange-500 my-1.5">Grow</h2>
                    <p className="font-bold my-1.5"><span className="text-xl">MZN 30O</span>/Mes</p>
                </div>
                <div className="rounded-2xl p-3 bg-gray-700/15">
                    <h2 className="font-bold text-orange-500 my-1.5">Scale</h2>
                    <p className="font-bold my-1.5"><span className="text-xl">MZN 80O</span>/Mes</p>
                </div>
            </div>
        </div>
    );
}