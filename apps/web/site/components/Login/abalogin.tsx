
import Redes from './networks';
export default function Abalogin() {
  return (
    <div>
    <div  className="flex min-h-[100dvh]  bg-[#f3f4f6] dark:bg-gray-50 items-center justify-center p-4">
      
   
      <div className=" flex w-full max-w-6xl bg-gradient-to-l  from-gray-600/14  to-white  rounded-[30px] shadow-[0_4px_8px_gray] overflow-hidden h-full  max-h-[90dvh]">
        
        <div className="bg-green-500   hidden lg:flex lg:w-5/12  p-12 flex-col justify-between text-white">
          <h2 className="text-3xl font-bold">Menu Link</h2>
          <p>We are with you</p>
        </div>

        <div className="w-full lg:w-7/12 p-6 sm:p-12 flex flex-col justify-center overflow-y-auto">
          <div className="max-w-md mx-auto w-full">
            <h2 className="text-2xl font-bold text-gray-900 mb-6">Create Account</h2>
            
            <form className="space-y-4">
              <input type="text" placeholder="Full Name" className="w-full border-b p-3 outline-none dark:bg-transparent" />
              <input type="email" placeholder="Email" className="w-full border-b p-3 outline-none dark:bg-transparent" />
              <input type="password" placeholder="Password" className="w-full border-b p-3 outline-none dark:bg-transparent" />
              
              <button className="w-full bg-green-500 text-white font-bold py-4 rounded-full mt-4 active:scale-95 transition-transform">
                Sign Up
              </button>
            </form>

            <div className="mt-8">
              <p className="text-center text-xs text-gray-400 uppercase mb-4">Or sign up with</p>
              <div className="flex justify-center gap-4 flex-wrap">
               


           <Redes />
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>
 
    </div>
  );
}
