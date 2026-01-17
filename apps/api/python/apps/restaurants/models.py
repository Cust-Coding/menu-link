from django.db import models

class Restaurants(models.Model):
    name = models.CharField(max_length=255)
    email = models.EmailField()
    phoneNumber = models.IntegerField(max_length=20)
    linkdln = models.URLField()