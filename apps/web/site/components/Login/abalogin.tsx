import Redes from './networks';

export default function Abalogin() {
  return (
    <div>
    
      <div className="flex min-h-[100dvh] bg-black items-center justify-center p-4">
        
   
        <div className="flex w-full max-w-6xl rounded-[30px] overflow-hidden h-full max-h-[90dvh]
                        bg-white/10 backdrop-blur-md border border-white/25 shadow-[0_8px_32px_0_rgba(0,0,0,0.37)]">
          
          <div className="bg-orange-600/80 backdrop-blur-sm  hidden lg:flex lg:w-5/12 p-2 flex-col justify-between text-white">
          
           <div className='bg-black  h-full w-full pt-10 px-4 pb-2
    rounded-tl-[30px] rounded-bl-[30px] rounded-br-[30px]
    [clip-path:polygon(0%_0%,_95%_0%,_80%_100%,_0%_100%)] shadow-lg 
    backdrop-blur-sm  hidden lg:flex  flex-col justify-between 
    '>
            <div>
              <h2 className="text-3xl font-bold  tracking-tighter">Menu Link</h2>
              <p className="opacity-80 mt-2">We are with you every step of the way.</p>
            </div>
            <div className="text-xs opacity-50">© 2026 Menu Link</div>
          </div>
          </div>
            

        
          <div className="w-full lg:w-7/12 p-6 sm:p-12 flex flex-col justify-center bg-white/90 dark:bg-gray-950/50 overflow-y-auto
          ">
            <div className="max-w-md mx-auto w-full">
              <h2 className="text-2xl font-bold text-gray-900 dark:text-white mb-6">Create Account</h2>
              
              <form className="space-y-4">
                <input type="text" placeholder="Full Name" className="w-full border-b border-gray-300 dark:border-gray-700 p-3 outline-none bg-transparent dark:text-white" />
                <input type="email" placeholder="Email" className="w-full border-b border-gray-300 dark:border-gray-700 p-3 outline-none bg-transparent dark:text-white" />
                <input type="password" placeholder="Password" className="w-full border-b border-gray-300 dark:border-gray-700 p-3 outline-none bg-transparent dark:text-white" />
                
                <button className="w-full bg-orange-600/80 hover:bg-orange-600 text-white font-bold py-4 rounded-full mt-4 active:scale-95 transition-all shadow-lg shadow-orange-500/30">
                  Sign Up
                </button>
              </form>

              <div className="mt-8">
                <p className="text-center text-xs text-gray-400 uppercase mb-4">Or sign up with</p>
                <div className="flex justify-center">
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