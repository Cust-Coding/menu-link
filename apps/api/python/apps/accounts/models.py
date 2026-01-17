from django.db import models
from django.contrib.auth.models import User




class Customer(models.Model):
    GENDER_MALE = "MALE"
    GENDER_FEMALE = "FEMALE"
    GENDER_OTHER = "OTHER"
    GENDER_CHOICES = [
        (GENDER_MALE , "Male"),
        (GENDER_FEMALE , "Female"),
        (GENDER_OTHER , "Other")
    ]
    
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    name = models.CharField(max_length=255, null=False)
    gender = models.CharField(max_length=10, null=False)



class Staff(models.Model):
    pass