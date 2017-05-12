require 'Mysql2'

client = Mysql2::Client.new(:host => 'localhost', :username => 'root', :password => '123456', :database => 'course')

results = client.query("select user_id, remember_me_digest from user_auths")
results.each do|row|
	puts row
end

File.open("user-auths.txt", "w") do |file|
	results = client.query("select user_id, remember_me_digest from user_auths")
	results.each do|row|
		# file.puts row
		file.puts "?userType=RegisteredUser&userIdDigest=#{row['user_id']}&rememberMeDigest=#{row['remember_me_digest']}"
	end
end