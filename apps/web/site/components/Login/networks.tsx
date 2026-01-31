export default function Redes () {

const imgs = [
  
    {
    src:'/imgs/google.svg' , alt:'google'
},
    {
    src:'/imgs/facebook.svg' , alt:'facebook'
},
{
    src:'/imgs/instagram.svg' , alt:'instagram'
},
{
    src:'/imgs/x.svg' , alt:'facebook'
},

]
    return(
        <div className="flex gap-10">
           {imgs.map((img,index)=>(
            
                <img key={index} src={img.src} alt={img.alt} className="w-5 h-5" /> 
          
           ))
           }
        </div>
    )
}
